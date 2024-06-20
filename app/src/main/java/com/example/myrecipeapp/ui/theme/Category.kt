package com.example.myrecipeapp.ui.theme

//"idCategory": "1",
//      "strCategory": "Beef",
//      "strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
//      "strCategoryDescription"
class Category(val idCategory:String,
               val strCategory:String,
               val strCategoryThumb:String,
               val strCategoryDescription:String
)
data class CategoriesResponse(val categories:List<Category>)