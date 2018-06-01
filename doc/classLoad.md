# Java 类加载器
* Bootstrap ClassLoader
* Extention ClassLoader
* Appclass Loader
##总结
* ClassLoader用来加载class文件的。
* 系统内置的ClassLoader通过双亲委托来加载指定路径下的class和资源。
* 可以自定义ClassLoader一般覆盖findClass()方法。
* ContextClassLoader与线程相关，可以获取和设置，可以绕过双亲委托的机制。