# BookShelfDemo
a demo to test for recyclerView hoder 200 local drawable and network img,check the memery size.
### 创建这个demo的用于是检测 使用recyclerView 加载多张本地图片（数量达到200) 和 使用图片框架Glide 及 Picasso分别加载网络图片200张，
    查看内存消耗情况。
    在一般的书架页中 一个人收藏200本书，的确算是非常巨大的一个数。所以在书架页中 这对用户收藏两百本书已经是一个极限。
    ###检查结果如下，如果将图片直接放置在drawbale目录下 ，会耗费大量内存。使用glide加载网络图片，比从本地加载图片耗费的内存多一些。使用picassso
    加载图片，如果不设定图片大小的法，会很耗费内存。指定大小之后内存消耗 比glide小。
