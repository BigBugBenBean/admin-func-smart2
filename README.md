# Checklist of getting start your development

  1. Replace all "\_sample\_" keywords of project to Department System Code
 - pom.xml<br/>
   line 14: `<artifactId>`<br/>
   line 19: `<description> `<br/>
<pre>
    &lt;groupId&gt;com.pccw.immd&lt;/groupId&gt;
    &lt;artifactId&gt;admin-func-module-__sample __&lt;/artifactId&gt;
    &lt;version&gt;1.0-SNAPSHOT&lt;/version&gt;
    &lt;packaging&gt;jar&lt;/packaging&gt;<br/><br/>
    &lt;name&gt;Admin Functions&lt;/name&gt;
    &lt;description&gt;Smartics2 Administrative Function - __sample __&lt;/description&gt;
</pre>
 - `src/main/java/` - Refactor Java package name <br/>
   from `"com.pccw.immd.adminfunc._sample_"` to `"com.pccw.immd.adminfunc.[SystemCode]"`. <br/>
  (Naming conversion of package name must be lowercase) <br/>
    E.g. <br/>
  `_sample_Controller.java`
 - `src/main/resource/META-INF/resources/` - Refactor static folder name <br/>
   from `_sample_` to  `[SystemCode]`  <br/>
   (lowercase)<br/>
    E.g. <br/>
    `_sample_/css/_sample_.css` <br/>
    `_sample_/js/_sample_.js`
 - `src/main/resource/templates/` - Refactor template folder name <br/>
   from `_sample_` to  `[SystemCode]`  <br/>
   (lowercase)
 - `src/main/resource/config/` - Refactor spring config file names <br/>
   from `_sample_*` to  `[]SystemCode*]`  <br/>
   (lowercase) <br/>
   E.g. <br/>
   `_sample_-application-context.xml` <br/>
   `_sample_-database-context.xml` <br/>
   `_sample_-web-context.xml` <br/>

