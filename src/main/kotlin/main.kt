package org.example

import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode

private class C

fun loadClass(path: String): ClassNode {
    val node = ClassNode()
    ClassReader(C::class.java.getResourceAsStream(path)).accept(node, ClassReader.SKIP_CODE)
    return node
}

fun ClassNode.dump() {
    println("$name => $sourceFile")
}

fun main() {
    loadClass("/org/example/AnnotatedFileKt.class").dump()
    loadClass("/org/example/A.class").dump()
    loadClass("/org/example/B.class").dump()
}
