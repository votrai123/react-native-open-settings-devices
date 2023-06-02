
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNOpenSettingsSpec.h"

@interface OpenSettings : NSObject <NativeOpenSettingsSpec>
#else
#import <React/RCTBridgeModule.h>

@interface OpenSettings : NSObject <RCTBridgeModule>
#endif

@end
