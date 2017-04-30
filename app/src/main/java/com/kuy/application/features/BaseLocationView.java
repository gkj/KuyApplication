package com.kuy.application.features;

import com.kuy.application.location.EasyLocationRequest;

/**
 * Created by gilang on 4/30/17.
 */

public interface BaseLocationView extends BaseView {
    void requestSingleLocationFix(EasyLocationRequest easyLocationRequest);
}
