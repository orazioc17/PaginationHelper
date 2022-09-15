class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {
    val itemCount = collection.count()
    val pageCount = (itemCount / itemsPerPage).inc()
    fun pageItemCount(index: Int) = collection.chunked(itemsPerPage).getOrNull(index)?.count() ?: -1
    fun pageIndex(index: Int) = if (itemCount == 0) -1 else (index / itemsPerPage).takeIf { index in 0..itemCount && it in 0..pageCount } ?: -1
}

class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {
    
    val itemCount: Int
    get() = collection.size

    val pageCount: Int
    get() = Math.ceil(itemCount.toDouble()/itemsPerPage).toInt()

    fun pageItemCount(pageIndex: Int): Int {
        if(pageIndex !in (0..pageCount-1)) return -1
        val diff = Math.abs(itemCount - pageIndex * itemsPerPage)
        return if(diff>itemsPerPage) itemsPerPage else diff
    }

    fun pageIndex(itemIndex: Int): Int {
        if(itemIndex !in (0..itemCount-1)) return -1
        return (itemIndex+1)/itemsPerPage 
    }
}
