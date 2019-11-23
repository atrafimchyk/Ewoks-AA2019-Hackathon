package by.ewoks.powervehicle

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

val IO_EXECUTOR: ExecutorService = Executors.newSingleThreadExecutor()

fun runOnIoThread(block: () -> Unit) {
    IO_EXECUTOR.execute(block)
}