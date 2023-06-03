#import "OpenSettings.h"
#import <UIKit/UIKit.h>
#import <CoreLocation/CoreLocation.h>

@implementation OpenSettings
RCT_EXPORT_MODULE()


RCT_EXPORT_METHOD(openSettings:(NSString *)value){
    dispatch_async(dispatch_get_main_queue(), ^{
      NSURL *URL = [NSURL URLWithString:UIApplicationOpenSettingsURLString];
      if([value isEqualToString:@"location"]){
        URL = [NSURL URLWithString:@"App-prefs:Privacy&path=LOCATION"];
      }
      if([value isEqualToString:@"wifi"]){
        URL = [NSURL URLWithString:@"App-prefs:WIFI"];
      }
      if([value isEqualToString:@"general"]){
        URL = [NSURL URLWithString:@"App-prefs:General"];
      }
      if([value isEqualToString:@"network"]){
        URL = [NSURL URLWithString:@"App-prefs:General&path=Network"];
      }
      if([value isEqualToString:@"security"]){
        URL = [NSURL URLWithString:@"App-prefs:Privacy"];
      }
      if([value isEqualToString:@"deviceinfo"]){
        URL = [NSURL URLWithString:@"App-prefs:General&path=About"];
      }
      if([value isEqualToString:@"backup"]){
        URL = [NSURL URLWithString:@"App-prefs:CASTLE&path=STORAGE_AND_BACKUP"];
      }
      if([value isEqualToString:@"sound"]){
        URL = [NSURL URLWithString:@"App-prefs:Sounds"];
      }
      if ([value isEqualToString:@"home"]) {
        URL = [NSURL URLWithString:UIApplicationOpenSettingsURLString];
      }
      if([value isEqualToString:@"date"]){
        URL = [NSURL URLWithString:@"App-prefs:General&path=DATE_AND_TIME"];
      }
      if([value isEqualToString:@"applications"]){
        URL = [NSURL URLWithString:@"App-prefs:General&path=STORAGE"];
    }
        

      if (([[[UIDevice currentDevice] systemVersion] floatValue] >= 10.0)) {
           [[UIApplication sharedApplication] openURL:URL options:@{} completionHandler:nil];
      }else{
        [[UIApplication sharedApplication] openURL:[NSURL URLWithString:UIApplicationOpenSettingsURLString] options:[NSDictionary dictionary] completionHandler:nil];
      }
      
       
    });
}


RCT_EXPORT_METHOD(checkAllowLocationServices:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        BOOL locationServicesEnabled = [CLLocationManager locationServicesEnabled];
        resolve(@(locationServicesEnabled));
     });
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeOpenSettingsSpecJSI>(params);
}
#endif

@end
