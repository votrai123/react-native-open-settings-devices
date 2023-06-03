import { NativeModules, Platform } from 'react-native';
import type { ESettings } from './types';

const LINKING_ERROR =
  `The package 'react-native-open-settings-devices' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const OpenSettings = NativeModules.OpenSettings
  ? NativeModules.OpenSettings
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

/**
 * @description function to open settings for platform android and ios
 * @param {value} value enum ESettings
 */
export function openSettings(value: ESettings): void {
  return OpenSettings?.openSettings(value);
}

/**
 * @description working only Platform Android
 */
export function locationSettings(): void {
  return OpenSettings?.openSettingsGPS();
}

/**
 * @description working only Platfrom IOS
 */
export async function checkAllowLocationServices(): Promise<boolean> {
  try {
    const checked = await OpenSettings?.checkAllowLocationServices();
    return checked;
  } catch {
    return false;
  }
}

export { ESettings } from './types';
