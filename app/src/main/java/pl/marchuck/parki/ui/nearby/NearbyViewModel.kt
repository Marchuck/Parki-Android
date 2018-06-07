package pl.marchuck.parki.ui.nearby

import android.Manifest
import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.content.Context.LOCATION_SERVICE
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import pl.marchuck.parki.App


class NearbyViewModel : ViewModel() {

    val locationData = ObservableField("")

    val errorLabel = ObservableField("")

    val progressVisible = ObservableBoolean(false)

    var host: NearbyFragment? = null

    val disposable = CompositeDisposable()

    @SuppressLint("MissingPermission")
    fun startUpdates() {
        progressVisible.set(true)
        errorLabel.set(null)
        addDisposable(RxPermissions(host?.activity!!)
                .requestLocation()
                .subscribe({
                    obtainLocationManager().requestLocationUpdates("fused", 0L, 0f, locationListener)

                }, {
                    errorLabel.set("Failed to fetch location, try again")
                }))
    }

    private fun addDisposable(_disposable: Disposable?) = disposable.add(_disposable)

    private fun obtainLocationManager() = App.context?.getSystemService(LOCATION_SERVICE) as LocationManager

    fun onLocationReceived(_location: Location) {
        val location = _location
        obtainLocationManager().removeUpdates(locationListener)
        progressVisible.set(false)
        locationData.set("Your location is $location")
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
        host = null
    }

    //define the listener
    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
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
