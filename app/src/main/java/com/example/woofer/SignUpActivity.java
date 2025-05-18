<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#5A2D82">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp"
        android:gravity="center_horizontal">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:background="#D000F3"
            android:padding="20dp"
            android:layout_marginTop="40dp"
            android:elevation="6dp">

            <!-- Title -->
            <TextView
                android:id="@+id/title"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/title"
                android:textSize="28sp"
                android:textStyle="bold"
                android:textColor="#9A00D6"
                android:layout_gravity="center_horizontal"
                android:paddingBottom="16dp" />

            <!-- Display name -->
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/displayName"
                android:textColor="#5A2D82"
                android:textStyle="bold"
                android:labelFor="@id/fullName" />

            <EditText
                android:id="@+id/fullName"
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:background="#000"
                android:textColor="#fff"
                android:hint="@string/displayName"
                android:autofillHints="Full name" />

            <!-- User Name -->
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/userID"
                android:textColor="#5A2D82"
                android:textStyle="bold"
                android:layout_marginTop="10dp"
                android:labelFor="@id/userName" />

            <EditText
                android:id="@+id/userID"
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:background="#000"
                android:textColor="#fff"
                android:hint="@string/userID"
                android:autofillHints="name" />

            <!-- Email -->
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/email"
                android:textColor="#5A2D82"
                android:textStyle="bold"
                android:layout_marginTop="10dp"
                android:labelFor="@id/email" />

            <EditText
                android:id="@+id/email"
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:background="#000"
                android:textColor="#fff"
                android:hint="@string/email"
                android:inputType="textEmailAddress"
                android:autofillHints="emailAddress" />

            <!-- Password -->
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/password"
                android:textColor="#5A2D82"
                android:textStyle="bold"
                android:layout_marginTop="10dp"
                android:labelFor="@id/password" />

            <EditText
                android:id="@+id/password"
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:background="#000"
                android:textColor="#fff"
                android:hint="@string/password"
                android:inputType="textPassword"
                android:autofillHints="password" />

            <!-- Sign In Button -->
            <Button
                android:id="@+id/signUpButton"
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:text="@string/sign_up"
                android:textColor="#D000F3"
                android:background="#000"
                android:layout_marginTop="20dp" />
        </LinearLayout>
    </LinearLayout>
</ScrollView>
