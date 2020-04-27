import DummyUtil.nestedCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


object DummyUtil {
    suspend inline fun DummyClass.nestedCall(
        context: CoroutineContext = Dispatchers.IO,
        crossinline action: () -> Unit
    ): Unit = withContext(context) {
        this@nestedCall.doAction {
            action()
        }
    }
}

fun main() {
    val d = DummyClass()
    runBlocking {
        d.nestedCall {
            println("Hello World")
        }
    }
}