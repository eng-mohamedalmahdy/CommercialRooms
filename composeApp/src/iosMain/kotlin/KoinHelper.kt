import framework.ContactPicker
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(contactPicker: ContactPicker) {
    startKoin {
        val contactPickerModule = module {
            factory<ContactPicker> { contactPicker }
        }
        modules(contactPickerModule)
    }
}