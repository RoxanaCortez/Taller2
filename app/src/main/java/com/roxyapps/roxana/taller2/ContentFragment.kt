package com.roxyapps.roxana.taller2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.roxyapps.roxana.taller2.models.DataCoin
import kotlinx.android.synthetic.main.activity_second.view.*
import kotlinx.android.synthetic.main.fragment_container_layout.view.*
import kotlinx.android.synthetic.main.lista_moneda.view.*

private const val ARG_CONTENT = "CONTENT"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ContentFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ContentFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ContentFragment : Fragment() {

    lateinit var coin: DataCoin

    companion object {
        fun newInstance(coin: DataCoin): ContentFragment{
            val newFragment = ContentFragment()
            newFragment.coin = coin
            return newFragment
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_container_layout, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View){
        view.nombre.text = coin.name
        view.pais.text = coin.country
        view.valor.text = coin.value.toString()
        view.valor.text = coin.value_us.toString()
        view.anio.text = coin.year.toString()
        view.disponible.text = coin.isAvailable.toString()
        Glide.with(view).load(coin.img)
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.image)
    }
}