package co.tiagoaguiar.tutorial.jokerappdev.data

interface ListCategoryCallback {
    // interface não tem corpo

    fun onSuccess(response: List<String>)

    fun onError(response: String)

    fun onComplete()

}