package space.pandaer.roomdemo.data

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object AccountMigration : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE account ADD COLUMN loginTime INTEGER NOT NULL DEFAULT 0")
    }
}