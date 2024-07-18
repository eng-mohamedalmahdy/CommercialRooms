package framework

import platform.posix.exit

actual fun exitApp() {
        exit(0)
}