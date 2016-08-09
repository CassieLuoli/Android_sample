/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.hw.sirius.thinktank.shared.ui.interfaces;

import android.content.Context;

/**
 * Interface representing a View that will use to load data.
 */
public interface LoadingView {
  public void showLoading();
  public void hideLoading();
  public void showRetry();
  public void hideRetry();
  public void showError(String message);
  public Context context();
}
