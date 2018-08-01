
# maven 中的 optional 
optional=true 的时候
A  B   在A的pom中依赖B且 optional=true 那么打包的时候， B 会打包到A项目的Classpath下面去
C  A  B  B 将不会打包到 C 项目的 classpath 下面去，你需要自己手动在C的pom中添加B的依赖才行

文档说明： http://maven.apache.org/guides/introduction/introduction-to-optional-and-excludes-dependencies.html
