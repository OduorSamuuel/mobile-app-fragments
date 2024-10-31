package com.example.basicapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicapp.adapters.PopularPlacesAdapter
import com.example.basicapp.adapters.RecommendedPlacesAdapter
import com.example.basicapp.databinding.FragmentHomeBinding
import com.example.basicapp.models.Place


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val popularPlacesAdapter = PopularPlacesAdapter()
    private val recommendedPlacesAdapter = RecommendedPlacesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViews()
        loadSampleData()
    }

    private fun setupRecyclerViews() {
        binding.popularPlacesRecycler.apply {
            adapter = popularPlacesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.recommendedPlacesRecycler.apply {
            adapter = recommendedPlacesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun loadSampleData() {
        val popularPlaces = listOf(
            Place(
                id = "1",
                name = "Alley Palace",
                imageUrl = "https://images.pexels.com/photos/1008155/pexels-photo-1008155.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                rating = 4.5f,
                reviews = 555,
                price = 199.0,
                description = "Beautiful palace in the heart of the city",
                location = "Aspen, USA"
            ),
            Place(
                id = "3",
                name = "Coeurdes Alpes",
                imageUrl = "https://images.pexels.com/photos/2664046/pexels-photo-2664046.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                rating = 4.8f,
                reviews = 655,
                price = 299.0,
                description = "Luxurious alpine resort with stunning views",
                location = "Aspen, USA"
            )
            // Add more sample popular places
        )

        val recommendedPlaces = listOf(
            Place(
                id = "3",
                name = "Coeurdes Alpes",
                imageUrl = "https://images.pexels.com/photos/2664046/pexels-photo-2664046.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                rating = 4.8f,
                reviews = 655,
                price = 299.0,
                description = "Luxurious alpine resort with stunning views",
                location = "Aspen, USA"
            ),
            Place(
                id = "3",
                name = "Coeurdes Alpes",
                imageUrl = "https://images.pexels.com/photos/2664046/pexels-photo-2664046.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                rating = 4.8f,
                reviews = 655,
                price = 299.0,
                description = "Luxurious alpine resort with stunning views",
                location = "Aspen, USA"
            ),
            Place(
                id = "3",
                name = "Coeurdes Alpes",
                imageUrl = "https://images.pexels.com/photos/2664046/pexels-photo-2664046.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                rating = 4.8f,
                reviews = 655,
                price = 299.0,
                description = "Luxurious alpine resort with stunning views",
                location = "Aspen, USA"
            )
            // Add more sample recommended places
        )

        popularPlacesAdapter.submitList(popularPlaces)
        recommendedPlacesAdapter.submitList(recommendedPlaces)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}