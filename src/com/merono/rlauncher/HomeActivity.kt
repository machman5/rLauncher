package com.merono.rlauncher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import rx.subjects.PublishSubject

class HomeActivity : AppCompatActivity() {

  private val destroys = PublishSubject.create<Unit>()

  init {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val view = SearchableLauncherView(this)
    setContentView(view)

    LauncherPresenter(
        view,
        installedApps(this),
        destroys.asObservable(),
        AppRouter(this)
    )
  }

  override fun onBackPressed() {
    // Intentionally don't call super so that the launcher isn't closed
    // when back is pressed
  }

  override fun onDestroy() {
    super.onDestroy()
    destroys.onNext(null)
  }
}
