package com.example.furniturestore.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.furniturestore.R
import com.example.furniturestore.models.ProductInfo

class ProdInfoDialog: DialogFragment() {
    private lateinit var ivClear: ImageView
    private lateinit var tvHeight: TextView
    private lateinit var tvWidth: TextView
    private lateinit var tvDepth: TextView
    private lateinit var tvWeight: TextView
    private lateinit var tvMainMaterial: TextView
    private lateinit var tvOtherMaterial: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.dialog_prod_info, container, false)
        ivClear = view.findViewById(R.id.ivClear)
        tvHeight = view.findViewById(R.id.tvHeightValue)
        tvWidth = view.findViewById(R.id.tvWidthValue)
        tvDepth = view.findViewById(R.id.tvDepthValue)
        tvWeight = view.findViewById(R.id.tvWeightValue)
        tvMainMaterial = view.findViewById(R.id.tvMainMaterialValue)
        tvOtherMaterial = view.findViewById(R.id.tvOtherMaterialValue)

        val product: ProductInfo? = arguments?.getParcelable("PRODUCTINFO")

        tvWidth.text = product?.width.toString() + " cm"
        tvHeight.text = product?.height.toString() + " cm"
        tvDepth.text = product?.depth.toString() + " cm"
        tvWeight.text = product?.weight.toString() + " kg"
        tvMainMaterial.text = product?.mainMaterial
        tvOtherMaterial.text = product?.otherMaterial

        ivClear.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }
}