package pl.marchuck.parki.ui.nearby

import android.Manifest
import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import pl.marchuck.parki.App
import pl.marchuck.parki.base.MutableData


class NearbyViewModel : ViewModel() {

    val pulsatorState = MutableData(PulsatorState.STOPPED)

    val locationData = MutableData("")

    val buttonVisibility = MutableData(true)

    @Volatile
    var location: Location? = null

    val errorLabel = MutableData("")

    var host: NearbyFragment? = null

    val disposable = CompositeDisposable()


    @SuppressLint("MissingPermission")
    fun startUpdates() {
        pulsatorState.set(PulsatorState.STARTED)
        locationData.set("Fetching your location...")
        buttonVisibility.set(false)
        errorLabel.set(null)
        addDisposable(RxPermissions(host?.activity!!)
                .requestLocation()
                .subscribe({

                    obtainLocationManager().requestLocationUpdates("fused",
                            400, 0f, locationListener)

                    Handler(Looper.getMainLooper()).postDelayed({
                        if (this.location == null) {
                            pulsatorState.set(PulsatorState.STOPPED)
                            locationData.set("")
                            errorLabel.set("Failed fetch location, try again later")
                        } else {

                        }
                    }, 5000)

                }, {
                    errorLabel.set("Failed to fetch location, try again")
                }))
    }

    private fun addDisposable(_disposable: Disposable?) = disposable.add(_disposable)

    private fun obtainLocationManager() = App.context?.getSystemService(LOCATION_SERVICE) as LocationManager

    fun onLocationReceived(location: Location) {
        this.location = location

        obtainLocationManager().removeUpdates(locationListener)
        pulsatorState.set(PulsatorState.STOPPED)

        errorLabel.set("")
        locationData.set("Your location is ${String.format("(%.3f, %.3f)", location.latitude, location.longitude)}")
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
        host = null
    }

    //define the listener
    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            println("onLocationChanged called with $location")
            onLocationReceived(location)
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
}

private fun RxPermissions.requestLocation(): Observable<Boolean> {
    return request(Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION)
}
