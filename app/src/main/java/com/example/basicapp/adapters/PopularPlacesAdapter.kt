package com.example.basicapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.basicapp.databinding.ItemPopularPlaceBinding
import com.example.basicapp.models.Place

class PopularPlacesAdapter : RecyclerView.Adapter<PopularPlacesAdapter.PlaceViewHolder>() {
    private var places = listOf<Place>()
    private var onItemClickListener: ((Place) -> Unit)? = null

    fun setOnItemClickListener(listener: (Place) -> Unit) {
        onItemClickListener = listener
    }

    fun submitList(newPlaces: List<Place>) {
        places = newPlaces
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = ItemPopularPlaceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(places[position])
    }

    override fun getItemCount() = places.size

    inner class PlaceViewHolder(
        private val binding: ItemPopularPlaceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(place: Place) {
            binding.apply {
                placeName.text = place.name
                ratingBar.rating = place.rating

                Glide.with(placeImage)
                    .load(place.imageUrl)
                    .centerCrop()
                    .into(placeImage)

                root.setOnClickListener {
                    onItemClickListener?.invoke(place)
                }
            }
        }
    }
}