class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {
    
   /**
   * returns the number of items within the entire collection
   */
  val itemCount: Int
    get() {
        return collection.size
    } 
    
  /**
   * returns the number of pages
   */
  val pageCount: Int
    get() {
        return if((collection.size % itemsPerPage) == 0) {
                collection.size / itemsPerPage
            } else {
                (collection.size / itemsPerPage) + 1
            }
    }


  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
  fun pageItemCount(pageIndex: Int): Int {
      return if (pageIndex !in 0 until pageCount) {
              -1
      } else {
          if (pageIndex == (pageCount - 1)) {
              if (pageCount  == 1 && itemCount > 0) {
                  return itemCount
              } else return (itemCount % itemsPerPage)
          } else {
              itemsPerPage
          }
      }
  }
  
  
  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  fun pageIndex(itemIndex: Int): Int {
      return if (itemIndex !in 0 until itemCount) {
          -1
      } else {
          return itemIndex / itemsPerPage
      }
  }
}
