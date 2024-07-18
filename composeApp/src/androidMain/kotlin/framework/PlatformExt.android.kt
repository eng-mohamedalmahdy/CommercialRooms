package framework


actual fun exitApp() {
    android.os.Process.killProcess(android.os.Process.myPid())
}