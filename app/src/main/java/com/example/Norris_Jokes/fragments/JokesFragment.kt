 package com.example.Norris_Jokes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Norris_Jokes.JokeAdapter
import com.example.Norris_Jokes.JokeItem
import com.example.Norris_Jokes.R

 // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JokesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JokesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var loadBtn:Button
    protected lateinit var rootView: View
    lateinit var recyclerView: RecyclerView

    var jokesList = ArrayList<JokeItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_jokes,container,false)
        loadBtn = rootView.findViewById(R.id.load_btn)


        loadBtn.setOnClickListener()
        {

            if (jokesList.size > 1)
            {
                jokesList.clear()
            }

            Toast.makeText(requireContext(),"Loading jokes...",Toast.LENGTH_SHORT).show()

            val numberOfJokesField = rootView.findViewById<TextView>(R.id.textView_quantity)
            var numberOfJokes = numberOfJokesField.text.toString().toInt()

//            jokesList.add(JokeItem("Test"))
//            val apiResponse = URL("http://api.icndb.com/jokes/random").readText()

//            jokesList.add(JokeItem(apiResponse))

            (1..numberOfJokes).forEach { i -> jokesList.add(JokeItem("\$i element"))}

            //TODO: Перезагрузка View и приоритетное расположение поля и кнопки.

            loadBtn.text = "Reload"
        }
//        return inflater.inflate(R.layout.fragment_jokes, container, false)
//        initView()

//        val jokesList = generateTestList(7)
        //TODO: Fix UI when recyclerView items has more elements

        recyclerView = rootView.findViewById(R.id.jokes_rcrView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = JokeAdapter(jokesList)

        return rootView
    }

//    private fun generateTestList(size: Int): List<JokeItem>{
//        val list = ArrayList<JokeItem>()
//
//        (0..size).forEach { i -> list.add(JokeItem("\$i element"))}
//
//        return list
//    }


//    private fun getJokes(): MutableList<String> {
//        val data = mutableListOf<String>()
//
//        (0..30).forEach { i -> data.add("\$i element")}
//
//        return data
//    }
//
//    private fun initView()
//    {
//        initializeRecyclerView()
//    }
//
//    private fun initializeRecyclerView()
//    {
////        recyclerView = rootView.findViewById(R.id.jokes_rcrView)
////        recyclerView.layoutManager = LinearLayoutManager(activity)
//        //recyclerView.adapter = adapter
//    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment JokesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JokesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}