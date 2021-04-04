package com.example.guatepreviene.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.viewmodel.MapaViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaFragment : Fragment(), OnMapReadyCallback {

    private lateinit var MapaviewModel: MapaViewModel
    private lateinit var mapa: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        MapaviewModel =
            ViewModelProvider(this).get(MapaViewModel::class.java)

        var root: View = inflater.inflate(R.layout.mapa_fragment, container, false)
        val supportMapFragment: SupportMapFragment = getChildFragmentManager().findFragmentById(R.id.google_map) as SupportMapFragment
        supportMapFragment.getMapAsync(this)

        return root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapa = googleMap
        Antut(googleMap)
    }
    fun Antut(googleMap: GoogleMap){
        mapa = googleMap
        var punto1: LatLng = LatLng(14.6090025,-90.525939)
        var punto2: LatLng = LatLng(14.85757246, -90.13527419)
        var punto3: LatLng = LatLng(14.69909519, -90.96114438)
        var punto4: LatLng = LatLng(14.39139145, -90.83098846)
        var punto5: LatLng = LatLng(14.25811806, -90.28012419)
        var punto6: LatLng = LatLng(14.721082, -91.105946)
        var punto7: LatLng = LatLng(14.996395, -91.52596)
        var punto8: LatLng = LatLng(14.56837423, -92.0230426)
        var punto9: LatLng = LatLng(14.401566, -91.301419)
        var punto10: LatLng = LatLng(14.37663831, -91.74080805)
        var punto11: LatLng = LatLng(15.202127, -91.819955)
        var punto12: LatLng = LatLng(15.3814893, -91.29316086)
        var punto13: LatLng = LatLng(14.93547995, -91.18847189)
        var punto14: LatLng = LatLng(14.94053995, -90.45542154)
        var punto15: LatLng = LatLng(15.79626294, -90.72859163)
        var punto16: LatLng = LatLng(16.99397009, -89.69134094)
        var punto17: LatLng = LatLng(15.31555085, -89.44456363)
        var punto18: LatLng = LatLng(15.03169045, -89.57141873)
        var punto19: LatLng = LatLng(14.85405561, -89.24090625)
        var punto20: LatLng = LatLng(14.56868472, -90.17777642)
        var punto21: LatLng = LatLng(14.251852, -89.753004)
        var punto22: LatLng = LatLng(15.43149389, -91.09642924)

        mapa.addMarker(MarkerOptions().position(punto1).title("Parque de la Industria, Guatemaña"))
        mapa.addMarker(MarkerOptions().position(punto2).title("Subinal, El Progreso, Guastatoya"))
        mapa.addMarker(MarkerOptions().position(punto3).title("Chirijuyu, Chimaltenango, Tecpan"))
        mapa.addMarker(MarkerOptions().position(punto4).title("El Rodeo, Escuintla, Escuintla"))
        mapa.addMarker(MarkerOptions().position(punto5).title("Los Esclavos, Santa Rosa, Cuilapa"))
        mapa.addMarker(MarkerOptions().position(punto6).title("Canoas, Solola, Panajachel"))
        mapa.addMarker(MarkerOptions().position(punto7).title("Chivarreto, Totonicapan, San Fransico el Alto"))
        mapa.addMarker(MarkerOptions().position(punto8).title("Los Encuentros, Quetzaltenango, Coatepeque"))
        mapa.addMarker(MarkerOptions().position(punto9).title("Gautalon, Suchitepequez, Rio Bravo"))
        mapa.addMarker(MarkerOptions().position(punto10).title("Nueva Candelaria, Retalhuleu, Retalhuleu"))
        mapa.addMarker(MarkerOptions().position(punto11).title("Los Cerezos, San Marcos, Tejutla"))
        mapa.addMarker(MarkerOptions().position(punto12).title("Chex, Huehuetenango, Aguacatan"))
        mapa.addMarker(MarkerOptions().position(punto13).title("Paxot, Quiche, Chupol"))
        mapa.addMarker(MarkerOptions().position(punto14).title("Los Amates, Baja Verapaz, El Chol"))
        mapa.addMarker(MarkerOptions().position(punto15).title("Puribal, Alta Verapaz, Coban"))
        mapa.addMarker(MarkerOptions().position(punto16).title("El Remate, Peten, Flores"))
        mapa.addMarker(MarkerOptions().position(punto17).title("Chinebal, Izabal, El Estor"))
        mapa.addMarker(MarkerOptions().position(punto18).title("Chispan, Zacapa, Estanzuela"))
        mapa.addMarker(MarkerOptions().position(punto19).title("Caparja, Chiquimula, Camotan"))
        mapa.addMarker(MarkerOptions().position(punto20).title("Brisas, Jalapa, Mataquescuintla"))
        mapa.addMarker(MarkerOptions().position(punto21).title("Tamarindo, Jutiapa, Asuncion Mita"))
        mapa.addMarker(MarkerOptions().position(punto22).title("Pulay, Ixil, Nebaj"))

        mapa.animateCamera(
            CameraUpdateFactory.newLatLngZoom(punto1, 18f),
            4000,
            null
        )
    }

}