package com.roxyapps.roxana.taller2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roxyapps.roxana.taller2.models.DataCoin
import kotlinx.android.synthetic.main.lista_moneda.view.*

class CoinAdapter (var items:List<DataCoin>, val clickListener: (DataCoin)-> Unit):RecyclerView.Adapter<CoinAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_moneda, parent, false)
        return ViewHolder(view)
    }
    //tercer paso
    //nos devuelve el tamaño de la lista, que lo necesita el RecyclerView.
    override fun getItemCount()= items.size

    // cuarto paso
    //se encarga de coger cada una de las posiciones de la lista de y
    // pasarlas a la clase ViewHolder para que esta pinte todos los valores.
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)=viewHolder.bind(items[position], clickListener)

    fun changeList(items: List<DataCoin>){
        this.items = items

        notifyDataSetChanged()
    }

    //Es lo que crea primero
    // Obtiene los valores de la de elementos igualando a la data asignada
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(coin:DataCoin, clickLister:(DataCoin)->Unit) = with(itemView){
            tv_nombre.text = coin.name
            tv_valor.text = coin.value.toString()
            this.setOnClickListener {clickLister(coin)}
        }
    }
}