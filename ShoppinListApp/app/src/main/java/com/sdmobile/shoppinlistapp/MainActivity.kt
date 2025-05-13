package com.sdmobile.shoppinlistapp

class MainActivity : AppCompatActivity() {
    private val productList = mutableListOf<Product>()
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicjalizacja RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // FloatingActionButton (FAB) - dodawanie produktu
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            showAddProductDialog()
        }
    }

    private fun showAddProductDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_product, null)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Dodaj produkt")
            .setView(dialogView)
            .setPositiveButton("Dodaj") { _, _ ->
                val productName = dialogView.findViewById<EditText>(R.id.etProductName).text.toString()
                if (productName.isNotEmpty()) {
                    productList.add(Product(productName))
                    adapter.notifyItemInserted(productList.size - 1)
                }
            }
            .setNegativeButton("Anuluj", null)
            .create()
        dialog.show()
    }
}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}