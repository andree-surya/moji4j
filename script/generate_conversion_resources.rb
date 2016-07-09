#!/usr/bin/env ruby

require 'mojinizer'

resources = File.expand_path('../src/main/resources', File.dirname(__FILE__))

romaji_to_katakana = {
}

romaji_to_katakana.merge!(Mojinizer::ROM_TO_KATA1)
romaji_to_katakana.merge!(Mojinizer::ROM_TO_KATA2)
romaji_to_katakana.merge!(Mojinizer::ROM_TO_KATA3)

romaji_to_katakana.merge!({
  'n' => 'ン', 
  'm' => 'ン',
  'n\'' => 'ン',
  'dzu' => 'ヅ'
})

File.open(File.join(resources, 'romaji_to_katakana.csv'), 'w') do |file|
  romaji_to_katakana.each { |k, v| file.puts "#{k},#{v}" }
end

File.open(File.join(resources, 'romaji_to_hiragana.csv'), 'w') do |file|
  romaji_to_katakana.each { |k, v| file.puts "#{k},#{v.kata_to_hira}" }
end

