#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_dell_pupil_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string version = "v1.0";
    std::string hello = "Hello from C++ " + version;
    return env->NewStringUTF(hello.c_str());
}
