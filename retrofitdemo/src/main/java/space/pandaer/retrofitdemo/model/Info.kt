package space.pandaer.retrofitdemo.model

data class Info(
    val desc: String,
    val result: List<Result>,
    val statusCode: String
)

data class Result(
    val content: String,
    val id: Int,
    val updateTime: String
)