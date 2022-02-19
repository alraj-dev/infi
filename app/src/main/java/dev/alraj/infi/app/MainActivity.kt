package dev.alraj.infi.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.children
import dev.alraj.infi.Infi
import dev.alraj.infi.app.databinding.ActivityMainBinding
import dev.alraj.infi.app.databinding.LayoutBoxBinding
import dev.alraj.infi.mutableInfiOf
import dev.alraj.infi.toInfi
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var vb: ActivityMainBinding
    private val box = mutableInfiOf<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        Timber.plant(Timber.DebugTree())

        vb.minus.setOnClickListener { onMinus() }
        vb.plus.setOnClickListener { onPlus() }
        vb.prev.setOnClickListener { onPrev() }
        vb.next.setOnClickListener { onNext() }
    }

    private fun onMinus() {
        vb.boxes.removeViewAt(vb.boxes.childCount - 1)
        box.removeLast()
        Timber.d("onMinus: box.size %d", box.size)
    }

    private fun onPlus() {
        val newBox = LayoutBoxBinding.inflate(layoutInflater, vb.boxes, false).root
        vb.boxes.addView(newBox)
        box.add(newBox)
        Timber.d("onPlus: box.size %d", box.size)
    }

    private fun onPrev() {
        if(vb.count.text.isBlank()) {
            Toast.makeText(this, "Count should not be empty", Toast.LENGTH_SHORT).show()
            return
        }

        box.element().setBackgroundResource(R.color.grey)
        box.previous(vb.count.text.toString().toInt()).setBackgroundResource(R.color.yellow)
    }

    private fun onNext() {
        if(vb.count.text.isBlank()) {
            Toast.makeText(this, "Cound should not be empty", Toast.LENGTH_SHORT).show()
            return
        }

        box.element().setBackgroundResource(R.color.grey)
        box.next(vb.count.text.toString().toInt()).setBackgroundResource(R.color.yellow)
    }
}