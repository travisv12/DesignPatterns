package Bridge.remotes;

import Bridge.devices.Device;
import Bridge.devices.SmartTV;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("Voice Command Received: " + command);
        if (device instanceof SmartTV) {
            SmartTV smartTV = (SmartTV) device;
            if (command.startsWith("browse ")) {
                String site = command.substring(7); // everything after "browse "
                smartTV.browseInternet(site);
            } else {
                System.out.println("Unknown voice command.");
            }
        } else {
            System.out.println("Voice control is not supported on this device.");
        }
    }
}
