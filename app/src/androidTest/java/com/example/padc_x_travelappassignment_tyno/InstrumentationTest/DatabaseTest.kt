package com.example.padc_x_travelappassignment_tyno.InstrumentationTest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.persistence.daos.TourDao
import com.example.padc_x_travelappassignment_tyno.persistence.db.TourDb
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var tourDao : TourDao
    private lateinit var db: TourDb

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TourDb::class.java).build()
        tourDao = db.tourDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest(){
        val tourOne = TourVO()
        tourOne.name = "Florence"
        tourOne.description =  "The hot chicken sandwich or simply \"hot chicken\" (Quebec French: sandwich chaud au poulet) is a type of chicken sandwich consisting of chicken, sliced bread, and gravy (which is generally poutine sauce). The sandwich is usually served with green peas and commonly found in Eastern Canadian cuisine. It's especially popular in Quebec and is often considered one of the province's staple dishes.[7][8] Since it is so commonly found in eateries of Quebec (Rôtisserie St-Hubert, Valentine, e.g.) and less seen outside the province, many Québécois regard it as a part of Quebec cuisine and believe it to have originated in the province.[7] This combination of chicken, gravy, and peas is known by its own term: galvaude,[7] seen in poutine galvaude.\n" +
                "\n" +
                "Although less featured in other areas of North America, the sandwich is also found in small diners from the Canadian Maritimes[9] and throughout the Southeastern United States.[10]\n" +
                "\n" +
                "The sandwich was a working-class dish already common and well established in North American cuisine by the early 1900s[11] and featured on the food menus of pharmacists and druggists of the time.[12] Due to its ease of preparation and its minimal costs, the sandwich was also widely served in the mess halls and cafeterias of the mid-1900s.[13][14]\n" +
                "\n" +
                "This style of sandwich often makes use of leftovers from a previous meal. Substituting turkey for the chicken would make a hot turkey sandwich[15] and substituting roast beef makes a variety of the roast beef sandwich.[16]"

         tourDao.insertTours(tourOne)

        assert(tourDao.getTourByName(tourOne.name).value?.name == tourOne.name)



    }
}