

package io.ionic.starter;

import android.content.Intent;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class HuggyPlugin extends Plugin {

    @PluginMethod()
    public void startChat(PluginCall call) {
        String value = call.getString("value");
        Log.i("CALLING NATIVE ACTIVITY", "I WAS CALLED");

        Intent intent = new Intent(getActivity(), HuggyChatActiviy.class);
        getActivity().startActivity(intent);

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }
}

