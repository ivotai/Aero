package com.sanre.app

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.ToastUtils
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun View.safeClicks(): Observable<Unit> = this.clicks()
    .throttleFirst(2, TimeUnit.SECONDS)

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

fun Fragment.startAct(cls: Class<*>) = startActivity(Intent(context, cls))

fun Context.startAct(cls: Class<*>) = startActivity(Intent(this, cls))

fun TextView.isEmpty(): Boolean = trimText().isEmpty()

fun TextView.trimText() = text.toString().trim()

fun String.toast() = ToastUtils.showShort(this)

