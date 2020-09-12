package com.sanre.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.ToastUtils
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun View.safeClicks(): Observable<Unit> = this.clicks()
    .throttleFirst(2000, TimeUnit.MILLISECONDS)

fun TextView.trimText() = this.text.toString().trim()

//fun <T> Single<T>.observeOnMain(lifecycleOwner: LifecycleOwner): Single<T> =
//    this.subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .compose(disposeOnDestroy(lifecycleOwner))
//
//fun <T> Observable<T>.observeOnMain(lifecycleOwner: LifecycleOwner): Observable<T> =
//    this.subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .compose(disposeOnDestroy(lifecycleOwner))
//
//fun RecyclerView.addDefaultItemDecoration(size: Int) {
//    HorizontalDividerItemDecoration.Builder(context)
//        .colorResId(R.color.md_grey_300)
//        .size(size)
//        .build().let { this.addItemDecoration(it) }
//}

fun Context.startAct(actClass: Class<*>) {
    this.startActivity(Intent(this, actClass))
}

fun Context.toActAndFinish(actClass: Class<*>) {
    this.startActivity(Intent(this, actClass))
    this as Activity
    this.finish()
}

fun TextView.isEmpty(): Boolean {
    return this.trimText().isEmpty()
}

fun String.toast() {
    ToastUtils.showShort(this)
}
