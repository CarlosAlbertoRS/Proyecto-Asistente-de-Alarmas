package com.example.proyasyst_test.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.R
import com.example.proyasyst_test.variables

class MedicamentoAdapter(private var medicamentos: List<variables>) :
    RecyclerView.Adapter<MedicamentoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtFecha: TextView = itemView.findViewById(R.id.fecha)
        val txtNombre: TextView = itemView.findViewById(R.id.medicamento)
        val txtFrecuencia: TextView = itemView.findViewById(R.id.administrada)
        val txtPeriodoTotal: TextView = itemView.findViewById(R.id.total)
        val txtEstado: TextView = itemView.findViewById(R.id.estado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_registro_activas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val medicamento = medicamentos[position]
        holder.apply {
            txtFecha.text = medicamento.fecha
            txtNombre.text = medicamento.nombre
            txtFrecuencia.text = medicamento.frecuencia
            txtPeriodoTotal.text = medicamento.periodoTotal
            txtEstado.text = medicamento.estado
        }
    }

    override fun getItemCount(): Int {
        return medicamentos.size
    }

    fun actualizarDatos(nuevosDatos: List<variables>) {
        medicamentos = nuevosDatos.toMutableList()
        notifyDataSetChanged()
    }

}
