package com.example.thirtydaysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.thirtydaysapp.R

data class Day(
    @StringRes val activity: Int,
    @DrawableRes val image: Int,
    @StringRes val explanation: Int
)


val activities = arrayOf(
    Day(R.string.activity_1, R.drawable.thank_you_515514, R.string.explanation_1),
    Day(R.string.activity_2, R.drawable.father_and_son_2258681, R.string.explanation_2),
    Day(R.string.activity_3, R.drawable.school_work_851328, R.string.explanation_3),
    Day(R.string.activity_4, R.drawable.old_books_436498, R.string.explanation_4),
    Day(R.string.activity_5, R.drawable.telephone_1324357, R.string.explanation_5),
    Day(R.string.activity_6, R.drawable.salad_2068220, R.string.explanation_6),
    Day(R.string.activity_7, R.drawable.interview_2211354, R.string.explanation_7),
    Day(R.string.activity_8, R.drawable.arrow_2886223, R.string.explanation_8),
    Day(R.string.activity_9, R.drawable.wordpress_265132, R.string.explanation_9),
    Day(R.string.activity_10, R.drawable.arches_national_park_1846759, R.string.explanation_10),
    Day(R.string.activity_11, R.drawable.arm_1284248, R.string.explanation_11),
    Day(R.string.activity_12, R.drawable.english_2724442, R.string.explanation_12),
    Day(R.string.activity_13, R.drawable.light_painting_6404195, R.string.explanation_13),
    Day(R.string.activity_14, R.drawable.buddhism_2214532, R.string.explanation_14),
    Day(R.string.activity_15, R.drawable.coffee_842020, R.string.explanation_15),
    Day(R.string.activity_16, R.drawable.morning_2243465, R.string.explanation_16),
    Day(R.string.activity_17, R.drawable.children_1822590, R.string.explanation_17),
    Day(R.string.activity_18, R.drawable.engagement_1361074, R.string.explanation_18),
    Day(R.string.activity_19, R.drawable.children_817365, R.string.explanation_19),
    Day(R.string.activity_20, R.drawable.man_2604149, R.string.explanation_20),
    Day(R.string.activity_21, R.drawable.sloth_5043324, R.string.explanation_21),
    Day(R.string.activity_22, R.drawable.holi_2416686, R.string.explanation_22),
    Day(R.string.activity_23, R.drawable.mobile_phone_5431597, R.string.explanation_23),
    Day(R.string.activity_24, R.drawable.checklist_6203690, R.string.explanation_24),
    Day(R.string.activity_25, R.drawable.guitar_756326, R.string.explanation_25),
    Day(R.string.activity_26, R.drawable.woman_1283009, R.string.explanation_26),
    Day(R.string.activity_27, R.drawable.volunteer_7788809, R.string.explanation_27),
    Day(R.string.activity_28, R.drawable.puzzle_pieces_7696621, R.string.explanation_28),
    Day(R.string.activity_29, R.drawable.tree_832079, R.string.explanation_29),
    Day(R.string.activity_30, R.drawable.millennial_2574751, R.string.explanation_30)
)