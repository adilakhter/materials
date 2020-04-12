// app/src/MinimalApplication.scala
       head(
         link(
           rel := "stylesheet",
           href := "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css"
         ),
+        script(raw("""
+          function submitForm(){
+            fetch(
+              "/",
+              {
+                method: "POST",
+                body: JSON.stringify({name: nameInput.value, msg: msgInput.value})
+              }
+            ).then(response => response.json())
+             .then(json => {
+              if (json["success"]) {
+                messageList.innerHTML = json["txt"]
+                msgInput.value = ""
+              }
+              errorDiv.innerText = json["err"]
+            })
+          }
+        """))
       ),
