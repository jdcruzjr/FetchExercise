package com.example.fetchexercise

class FetchItems(itemName: String, itemListId: Int, itemId: Int) {
    private var name : String = itemName
    private var listId: Int = itemListId
    private var id: Int = itemId

    fun getName() : String{
        return name
    }

    fun getListId(): Int{
        return listId
    }

    fun getId(): Int{
        return id
    }
}