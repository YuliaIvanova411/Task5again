 data class Comments (
    val count: Int = 0,
    val canPost: Boolean = true,
    val groopsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)


data class Post(
    var id: Int = 1,
    val data: Int = 1560507488,
    val fromId: Int = 2,
    val text: String = "Something written",
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val postType: String = "Post",
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val isFavourite: Boolean = false,
    val markedAsAds: Boolean = false
)


object WallService {
    var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
    }
    fun add(post: Post): Post {
        val newId: Int = if (posts.isEmpty()) 1
        else (posts.last().id + 1)
        posts += post.copy(id = newId)
        return posts.last()
    }
    fun print() {
        println(posts)
    }

    fun update(post: Post): Boolean {
        var result = false
        for ((index, oldPost) in posts.withIndex()) {
            if (post.id == oldPost.id) {
                posts[index] = post.copy(id = posts[index].id, data = posts[index].data )
                result = true
            }

        }
        return result
    }

}


fun main() {

    val post1 = Post(1, comments = Comments(1))
    WallService.add(post1)
    val post2 = Post (2, comments = Comments(0))
    WallService.add(post2)
    WallService.print()

}
