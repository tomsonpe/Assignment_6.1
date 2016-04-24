package com.ddd.assignment_6;

import assignment_7.factory.TestCash;
import assignment_7.factory.TestVideo;
import assignment_7.factory.TestVideoEditor;
import assignment_7.factory.TestWedding;
import assignment_7.factory.TestCheque;
import assignment_7.factory.TestCredit;
import assignment_7.factory.TestFunerals;
import assignment_7.factory.TestGraduation;
import assignment_7.factory.TestPhoto;
import assignment_7.factory.TestPhotoEditor;
import assignment_7.factory.TestReligion;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Created by 214162966 on 4/17/2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCash.class,
        TestVideo.class,
        TestVideoEditor.class,
        TestWedding.class,
        TestCheque.class,
        TestCredit.class,
        TestFunerals.class,
        TestPhoto.class,
        TestPhotoEditor.class,
        TestReligion.class})
class ApplicationTestSuit {
}
