# react-native-open-settings


The library is used to open settings for platform Android and IOS, and it uses for React Native

## Installation


```other
npm install react-native-open-settings-devices
```


Or:

```other
yarn add react-native-open-setting-devices
```


## Usage

1. Use to open setting platform **Android** and **IOS**

```other
import { openSettings, ESettings } from 'react-native-open-settings-devices';


// Example
openSettings(ESettings.GENERAL);
```

2. Use to open location service for **Android**

```other
import { locationSettings } from 'react-native-open-settings-devices';

// Example
locationSettings();
```

3. Use to check location service enable for **IOS**

```other
import { checkAllowLocationServices } from 'react-native-open-settings-devices';

// Example

const openLocationSettins = async () => {
	const result = await checkAllowLocationServices(); 
	return result;
}

```


## Example 


***ANDROID***
![Example for android](images/android.gif)

***IOS***

![Example for ios](images/ios.gif)


## Contributing


See the contributing guide to learn how to contribute to the repository and the development workflow.

## License


MIT
----

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
