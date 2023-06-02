import { NativeModules, Platform } from 'react-native';
import type { ESettings } from './types';

const LINKING_ERROR =
  `The package 'react-native-open-settings' doesn't seem to be linked. Make sure: \n\n` +
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

export function openSettings(value: ESettings): void {
  return OpenSettings?.openSettings(value);
}

export function locationSettings(): void {
  return OpenSettings?.locationSettings();
}

export { ESettings } from './types';
