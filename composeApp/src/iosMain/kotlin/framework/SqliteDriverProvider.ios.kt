package framework

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.thekupe.ugate.ProjectsDatabase


class DriverFactoryIosImpl : DriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(ProjectsDatabase.Schema, "projects.db")
    }

}