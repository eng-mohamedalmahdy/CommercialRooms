# Preserve annotations
-keepattributes *Annotation*

# Keep the names of all classes and class members in the specified packages
-keep class commercialrooms.** { *; }

# Keep specific classes
-keep class commercialrooms.MainActivity { *; }

# Keep all model classes used by Gson
-keep class com.thekupe.ion_community.models.** { *; }

# Keep all Firebase database model classes
-keepclassmembers class * {
    @com.google.firebase.database.IgnoreExtraProperties *;
}

# Remove logging (if you use Napier)
-assumenosideeffects class io.github.aakira.napier.Napier {
    public static void v(...);
    public static void d(...);
    public static void i(...);
    public static void w(...);
    public static void e(...);

}

# Prevent obfuscation for Retrofit and OkHttp
-keepattributes Signature
-keepattributes Exceptions
-keepattributes *Annotation*
-keepattributes InnerClasses


# Prevent obfuscation for Ktor
-keep class io.ktor.** { *; }
-keepclassmembers class io.ktor.** { *; }
-dontwarn io.ktor.**

# Keep classes required by the application
-keep class com.thekupe.ion_community.utils.** { *; }

# Optimization options
-dontwarn com.thekupe.ion_community.**

# Optional: Enable optimization
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

# Keep Logback classes and their members
-keep class ch.qos.logback.** { *; }

# Keep Groovy classes used by Logback
-keep class groovy.lang.** { *; }
-keep class org.codehaus.groovy.** { *; }
-keep class org.codehaus.commons.compiler.** { *; }

# Keep JMX classes used by Logback
-keep class javax.management.** { *; }

# Keep JNDI classes used by Logback
-keep class javax.naming.** { *; }

# Keep Servlet classes used by Logback
-keep class javax.servlet.** { *; }

# This is generated automatically by the Android Gradle plugin.
-dontwarn groovy.lang.Binding
-dontwarn groovy.lang.Closure
-dontwarn groovy.lang.GroovyClassLoader
-dontwarn groovy.lang.GroovyObject
-dontwarn groovy.lang.GroovyShell
-dontwarn groovy.lang.MetaClass
-dontwarn groovy.lang.MetaProperty
-dontwarn groovy.lang.Reference
-dontwarn groovy.lang.Script
-dontwarn java.lang.management.ManagementFactory
-dontwarn javax.mail.Address
-dontwarn javax.mail.Authenticator
-dontwarn javax.mail.BodyPart
-dontwarn javax.mail.Message$RecipientType
-dontwarn javax.mail.Message
-dontwarn javax.mail.Multipart
-dontwarn javax.mail.PasswordAuthentication
-dontwarn javax.mail.Session
-dontwarn javax.mail.Transport
-dontwarn javax.mail.internet.AddressException
-dontwarn javax.mail.internet.InternetAddress
-dontwarn javax.mail.internet.MimeBodyPart
-dontwarn javax.mail.internet.MimeMessage
-dontwarn javax.mail.internet.MimeMultipart
-dontwarn javax.management.InstanceNotFoundException
-dontwarn javax.management.MBeanRegistrationException
-dontwarn javax.management.MBeanServer
-dontwarn javax.management.MalformedObjectNameException
-dontwarn javax.management.ObjectInstance
-dontwarn javax.management.ObjectName
-dontwarn javax.naming.Context
-dontwarn javax.naming.InitialContext
-dontwarn javax.naming.NamingException
-dontwarn javax.servlet.Filter
-dontwarn javax.servlet.FilterChain
-dontwarn javax.servlet.FilterConfig
-dontwarn javax.servlet.ServletContainerInitializer
-dontwarn javax.servlet.ServletContext
-dontwarn javax.servlet.ServletContextEvent
-dontwarn javax.servlet.ServletContextListener
-dontwarn javax.servlet.ServletException
-dontwarn javax.servlet.ServletRequest
-dontwarn javax.servlet.ServletResponse
-dontwarn javax.servlet.http.HttpServlet
-dontwarn javax.servlet.http.HttpServletRequest
-dontwarn javax.servlet.http.HttpServletResponse
-dontwarn javax.xml.stream.Location
-dontwarn javax.xml.stream.XMLEventReader
-dontwarn javax.xml.stream.XMLInputFactory
-dontwarn javax.xml.stream.XMLStreamException
-dontwarn javax.xml.stream.events.Attribute
-dontwarn javax.xml.stream.events.Characters
-dontwarn javax.xml.stream.events.EndElement
-dontwarn javax.xml.stream.events.StartElement
-dontwarn javax.xml.stream.events.XMLEvent
-dontwarn org.codehaus.commons.compiler.CompileException
-dontwarn org.codehaus.groovy.control.CompilationFailedException
-dontwarn org.codehaus.groovy.control.CompilerConfiguration
-dontwarn org.codehaus.groovy.control.customizers.ImportCustomizer
-dontwarn org.codehaus.groovy.reflection.ClassInfo
-dontwarn org.codehaus.groovy.runtime.ArrayUtil
-dontwarn org.codehaus.groovy.runtime.BytecodeInterface8
-dontwarn org.codehaus.groovy.runtime.GStringImpl
-dontwarn org.codehaus.groovy.runtime.GeneratedClosure
-dontwarn org.codehaus.groovy.runtime.ScriptBytecodeAdapter
-dontwarn org.codehaus.groovy.runtime.callsite.CallSite
-dontwarn org.codehaus.groovy.runtime.callsite.CallSiteArray
-dontwarn org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation
-dontwarn org.codehaus.groovy.runtime.typehandling.ShortTypeHandling
-dontwarn org.codehaus.groovy.runtime.wrappers.Wrapper
-dontwarn org.codehaus.groovy.transform.ImmutableASTTransformation
-dontwarn org.codehaus.janino.ClassBodyEvaluator
-dontwarn org.codehaus.janino.ScriptEvaluator
-dontwarn sun.reflect.Reflection