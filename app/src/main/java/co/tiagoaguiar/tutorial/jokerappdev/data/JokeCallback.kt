package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke

interface JokeCallback {
    // interface não tem corpo

    fun onSuccess(response: Joke)

    fun onError(response: String)

    fun onComplete()

}