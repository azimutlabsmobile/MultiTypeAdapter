# MultiTypeAdapter

MultiTypeAdapter is an android library for dealing with a representation of RecyclerView items.
It can be useful to use single recycler view with multiple type of view and multiple type of object.

## Usage

1. Create RecyclerView container in xml

```xml
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/labelTextView" />
```

2. Create xml view for RecyclerView items [item_text_view.xml]

```xml
<?xml version="1.0" encoding="utf-8"?>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/textView"
    android:layout_width="match_parent"
    android:layout_height="48dp"
    android:fontFamily="sans-serif-black"
    android:gravity="center"
    android:textColor="@color/white"
    tools:text="Sample"
    android:background="@color/teal_200"
    android:layout_marginBottom="8dp"
    android:layout_marginHorizontal="8dp"/>
```


3. Create ViewBinders for MultiTypeAdapter

```kotlin
class TextViewBinder : ItemViewBinder<String, TextViewBinder.ViewHolder>() {

    //inflate item_text_view.xml
    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) = ViewHolder(inflater.inflate(R.layout.item_text_view, parent, false))

    override fun onBindViewHolder(holder: TextViewBinder.ViewHolder, item: String) {
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) = with(itemView) {
            textView.text = item
        }
    }
}
```


4. Create an instance of MultiTypeAdapter in Activity/Fragment (where you need to show a RecyclerView)

```kotlin

/**
 *  !!! Only for example
 *  The MultiTypeAdapter takes any kind of object to represent the recycler items.
 *  The list shown below contains two types like String and Int.
 */
private val listItems = arrayListOf<Any>(
    "You can user several type of Object in single RecyclerView",
    "You can use several type of View in single RecyclerView",
    1, 2, 3, 4, 5, 6, 7
)

/**
 *  Despite to the difference of types which multiTypeAdapter takes for input,
 *  the registered viewBinders can define what kind of type they must be operated for output
 */
private val multiAdapter = MultiTypeAdapter().apply {
    register(TextViewBinder())
    register(CardViewBinder {
        showMessage(it.toString())
    })
}
```

5. Setup recyclerView and multiTypeAdapter

```kotlin
private fun setupView() {
    recyclerView.apply {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = multiAdapter
    }
}

private fun setupAdapter() {
    multiAdapter.apply {
        items = listItems
        notifyDataSetChanged()
    }
}
```

## Screenshot
![Result](https://github.com/azimutlabsmobile/MultiTypeAdapter/blob/master/screenshots/multiTypeResult.png)

## Source
[Link to the root project](https://github.com/drakeet/MultiType)

## Additional

You can see the detailed example of MultiTypeAdapter in app folder of the project.


```groovy
dependencies {
    implementation 'com.github.azimutlabsmobile:MultiTypeAdapter:1.0.4'
}
```





