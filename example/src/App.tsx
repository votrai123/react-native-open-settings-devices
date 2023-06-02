import * as React from 'react';

import {
  StyleSheet,
  View,
  Text,
  TouchableOpacity,
  FlatList,
} from 'react-native';
import {
  openSettings,
  locationSettings,
  ESettings,
} from 'react-native-open-settings';

export default function App() {
  return (
    <View style={styles.container}>
      <FlatList
        data={Object.values(ESettings)}
        keyExtractor={(e) => e.toString()}
        renderItem={({ item }: { item: ESettings }) => (
          <TouchableOpacity
            activeOpacity={0.7}
            onPress={() => openSettings(item)}
            style={styles.button}
          >
            <Text style={styles.content}>Open {item} setting ➤</Text>
          </TouchableOpacity>
        )}
      />
      <TouchableOpacity
        activeOpacity={0.7}
        onPress={() => locationSettings()}
        style={styles.button}
      >
        <Text style={styles.content}>Open location setting</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  button: {
    padding: 20,
    margin: 8,
    borderRadius: 4,
    borderWidth: StyleSheet.hairlineWidth,
    backgroundColor: 'rgb(242, 212, 162)',
  },
  content: {
    fontWeight: 'bold',
    fontSize: 18,
  },
});
